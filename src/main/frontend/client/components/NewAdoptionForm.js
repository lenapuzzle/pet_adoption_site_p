import React, { useState } from "react"
import _ from 'lodash'

import HomeStatusField from "./HomeStatusField"
import ErrorList from "./ErrorList"

const NewAdoptionForm = (props) => {
  const [formPayload, setFormPayload] = useState({
    name: "",
    phoneNumber: "",
    email: "",
    homeStatus: ""
  })
  const [errors, setErrors] = useState({})

  const validForSubmission = () => {
    const errors = {}
    for(const field in formPayload) {
      if(formPayload[field].trim() === "") {
        errors[field] = "is blank"
      }
    }
    setErrors(errors)
    return _.isEmpty(errors)
  }

  const clearForm = () => {
    setFormPayload({
      name: "",
      phoneNumber: "",
      email: "",
      homeStatus: ""
    })
    setErrors({})
  }

  const handleSubmit = (event) => {
    event.preventDefault()
    if(validForSubmission()) {
      props.postAdoptionApp(formPayload)
      clearForm()
    }
  }

  const handleInputChange = event => {
    setFormPayload({
      ...formPayload,
      [event.currentTarget.name]: event.currentTarget.value
    })
  }

  return (
    <form className="callout" onSubmit={handleSubmit}>
      <ErrorList errors={{...errors, ...props.errors}} />
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
        <label htmlFor="phoneNumber">Phone Number: </label>
        <input
          name="phoneNumber"
          id="phoneNumber"
          type="text"
          value={formPayload.phoneNumber}
          onChange={handleInputChange}
        />
      </div>

      <div>
        <label htmlFor="email">Email: </label>
        <input
          name="email"
          id="email"
          type="text"
          value={formPayload.email}
          onChange={handleInputChange}
        />
      </div>
      
      <HomeStatusField
        handleInputChange={handleInputChange}
        homeStatus={formPayload.homeStatus}
      />
      <input className="button" type="submit" value="Submit" />
    </form>
  )
}


export default NewAdoptionForm
