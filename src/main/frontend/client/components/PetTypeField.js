import React, { useEffect, useState } from 'react'

const PetTypeField = props => {
  const [petTypes, setPetTypes] = useState([])

  const fetchPetTypes = async () => {
    try {
      const response = await fetch("/api/v1/pet-types")
      if(!response.ok) {
        const errorMessage = `${response.status} (${response.statusText})`
        const error = new Error(errorMessage)
        throw(error)
      }
      const petTypesData = await response.json()
      petTypesData.petTypes.unshift({name: "", id: null})
      setPetTypes(petTypesData.petTypes)
    } catch(err) {
      console.error(`Error in fetch: ${err.message}`)
    }
  }

  useEffect(() => {
    fetchPetTypes()
  }, [])

  const petTypeOptions = petTypes.map(type => {
    return(
      <option key={type.id} value={type.id}>
        {type.name}
      </option>
    ) 
  })

  return(
    <div>
      <label htmlFor="petTypeId">Pet Type:</label>
      <select name="petTypeId" id="petTypeId" onChange={props.handleInputChange} value={props.petTypeId}>
        {petTypeOptions}
      </select>
    </div>
  )
}

export default PetTypeField