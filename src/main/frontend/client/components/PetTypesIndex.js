import React, { useEffect, useState } from 'react';

import PetTypeTile from "./PetTypeTile"

const PetTypesIndex = props => {
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
      setPetTypes(petTypesData.petTypes)
    } catch(err) {
      console.error(`Error in fetch: ${err.message}`)
    }
  }

  useEffect(() => {
    fetchPetTypes()
  }, [])

  const petTypeTiles = petTypes.map(petType => {
    return (
      <PetTypeTile
        key={petType.id}
        petType={petType}
      />
    )
  })

  return(
    <div>
      {petTypeTiles}
    </div>
  )
}

export default PetTypesIndex