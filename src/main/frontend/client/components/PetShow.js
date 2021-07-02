import React, { useEffect, useState } from 'react';
import NewAdoptionForm from './NewAdoptionForm';

const PetShow = (props) => {
  const [pet, setPet] = useState({})
  const [formErrors, setFormErrors] = useState({})
  const [showForm, setShowForm] = useState(false)
  const [successfulApplicationStatus, setSuccessfulApplicationStatus] = useState(false)
  const petId = props.match.params.id
  
  const fetchPet = async () => {
    try {
      const response = await fetch(`/api/v1/pets/${petId}`)
      if(!response.ok) {
        const errorMessage = `${response.status} (${response.statusText})`
        const error = new Error(errorMessage)
        throw(error)
      }
      const petData = await response.json()
      setPet(petData.pet)
    } catch(err) {
      console.error(`Error in fetch: ${err.message}`)
      setPet(null)
    }
  }

  useEffect(() => {
    fetchPet()
  }, [])

  const addAdoptionApp = async(petPayload) => {
    try {
      const response = await fetch(`/api/v1/pets/${petId}/adoption-applications`, {
        method: 'POST',
        headers: new Headers({
          'Content-Type': 'application/json'
        }),
        body: JSON.stringify(petPayload)
      })
      if (!response.ok) {
        if(response.status === 422) {
          const body = await response.json()
          return setFormErrors(body.errors)
        } else {
          const errorMessage = `${response.status} (${response.statusText})`
          const error = new Error(errorMessage)
          throw(error)
        }
      }

      setSuccessfulApplicationStatus(true) 
      setShowForm(false)
    } catch(err) {
      console.error(`Error in fetch: ${err.message}`)
    }
  }

  if(!pet) {
    return(
      <h1>That Pet could not be found!</h1>
    )
  } 

  const { name, imgUrl, age, vaccinationStatus, adoptionStory, availableForAdoption } = pet

  let vaccinationStatusText = "No";
  if(vaccinationStatus) {
    vaccinationStatusText = "Yes"
  }

  let availableForAdoptionText = "No";
  if(availableForAdoption) {
    availableForAdoptionText = "Yes"
  }

  let adoptionStoryTag;
  if(adoptionStory) {
    adoptionStoryTag = <p><strong>Adoption Story: </strong>{adoptionStory}</p>
  }

  let successMessageTag;
  if(successfulApplicationStatus) {
    successMessageTag = <p><strong>Your request is in process.</strong></p>
  }

  let newAdoptionApplicationForm
  if(showForm) {
    newAdoptionApplicationForm = <NewAdoptionForm 
      errors={formErrors}
      postAdoptionApp={addAdoptionApp}
    />
  }

  const handleAdoptButtonClick = event => {
    event.preventDefault()
    setShowForm(true)
  }

  return (
    <div>
      {successMessageTag}
      <img src={imgUrl} className="pet-image" />
      <h1>{name}</h1>
      <p><strong>Age: </strong>{age}</p>
      <p><strong>Vaccinated?: </strong>{vaccinationStatusText}</p>
      <p><strong>Available For Adoption?: </strong>{availableForAdoptionText}</p>
      {adoptionStoryTag}
      <button type="button" className="button" onClick={handleAdoptButtonClick}>Adopt Me!</button>
      {newAdoptionApplicationForm}
    </div>
  )
}

export default PetShow