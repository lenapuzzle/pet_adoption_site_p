import React, { useState } from "react"
import { Redirect } from "react-router"
import _ from 'lodash'

import PetTypeField from "./PetTypeField"
import ErrorList from "./ErrorList"

const NewSurrenderForm = (props) => {
  const [formPayload, setFormPayload] = useState({
    name: "",
    age: "",
    imgUrl: "",
    adoptionStory: "",
    vaccinationStatus: false,
    petTypeId: ""
  })
  const [errors, setErrors] = useState({})
  const [petId, setPetId] = useState(null)
  const [shouldRedirect, setShouldRedirect] = useState(false)

  const validForSubmission = () => {
    const errors = {}
    const requiredFields = ["name", "imgUrl", "petTypeId"]
    requiredFields.forEach(field => {
      if(formPayload[field].trim() === "") {
        errors[field] = "is blank"
      }
    })
    setErrors(errors)
    return _.isEmpty(errors)
  }

  const addPet = async() => {
    try {
      const response = await fetch(`/api/v1/pets`, {
        method: 'POST',
        headers: new Headers({
          'Content-Type': 'application/json'
        }),
        body: JSON.stringify(formPayload)
      })
      if (!response.ok) {
        if(response.status === 422) {
          const body = await response.json()
          return setErrors(body.errors)
        } else {
          const errorMessage = `${response.status} (${response.statusText})`
          const error = new Error(errorMessage)
          throw(error)
        }
      }

      const body = await response.json()
      setPetId(body.pet.id)
      setShouldRedirect(true) 
    } catch(err) {
      console.error(`Error in fetch: ${err.message}`)
    }
  }

  const handleSubmit = (event) => {
    event.preventDefault()
    console.log(formPayload);
    if(validForSubmission()) {
      addPet()
    }
  }

  const handleInputChange = event => {
    if(event.target.type === "checkbox") {
      setFormPayload({
        ...formPayload,
        [event.currentTarget.name]: event.currentTarget.checked
      })
    } else {
      setFormPayload({
        ...formPayload,
        [event.currentTarget.name]: event.currentTarget.value
      })
    }
  }

  if (shouldRedirect) {
    return <Redirect push to={`/pets/${petId}`} />
  }

  console.log(formPayload);

  return (
    <form className="callout" onSubmit={handleSubmit}>
      <ErrorList errors={errors} />
      <div>
        <label htmlFor="name">Name: </label>
        <input
          name="name"
          id="name"
          type="text"
          value={formPayload.name}
          onChange={handleInputChange}
        />
      </div>

      <div>
        <label htmlFor="age">Age: </label>
        <input
          name="age"
          id="age"
          type="number"
          value={formPayload.age}
          onChange={handleInputChange}
        />
      </div>

      <div>
        <label htmlFor="imgUrl">Image URL: </label>
        <input
          name="imgUrl"
          id="imgUrl"
          type="text"
          value={formPayload.imgUrl}
          onChange={handleInputChange}
        />
      </div>

      <div>
        <label htmlFor="adoptionStory">Adoption Story: </label>
        <input
          name="adoptionStory"
          id="adoptionStory"
          type="text"
          value={formPayload.adoptionStory}
          onChange={handleInputChange}
        />
      </div>

      <div>
        <label htmlFor="vaccinationStatus">Vaccinated?: </label>
        <input
          name="vaccinationStatus"
          id="vaccinationStatus"
          type="checkbox"
          value={formPayload.vaccinationStatus}
          onChange={handleInputChange}
        />
      </div>
      
      <PetTypeField
        handleInputChange={handleInputChange}
        petTypeId={formPayload.petTypeId}
      />
      <input className="button" type="submit" value="Submit" />
    </form>
  )
}


export default NewSurrenderForm
