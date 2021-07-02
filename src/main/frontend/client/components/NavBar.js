import React, { useState, useEffect } from "react"
import { Switch, Route, Link, Redirect } from "react-router-dom"

import PetTypesIndex from "./PetTypesIndex"
import PetTypeShow from "./PetTypeShow"
import PetShow from "./PetShow"
import NewSurrenderForm from "./NewSurrenderForm"

const NavBar = props => {
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

  const petTypeLinks = petTypes.map(petType => {
    return (
      <li key={petType.id} className="menu-text">
        <Link to={`/pet-types/${petType.id}`}>{petType.name}</Link>
      </li>
    )
  })

  petTypeLinks.unshift(
    <li key={0} className="menu-text">
        <Link to={`/pet-types`}>All Pet Types</Link>
    </li>
  )

  return (
    <div>
    <div className="top-bar">
      <div className="top-bar-left">
        <ul className="menu">
          {petTypeLinks}
        </ul>
      </div>
      <div className="top-bar-right">
        <div className="menu-text">
          <Link to="/pets/new">List a Pet for Adoption</Link>
        </div>
      </div>
      </div>
      <Switch>
        <Route exact path="/">
          <Redirect to="/pet-types" />
        </Route>
        <Route exact path="/pet-types" component={PetTypesIndex} />
        <Route exact path="/pet-types/:id" component={PetTypeShow} />
        <Route exact path="/pets/new" component={NewSurrenderForm} />
        <Route exact path="/pets/:id" component={PetShow} />
      </Switch>
    </div>
  )
}

export default NavBar