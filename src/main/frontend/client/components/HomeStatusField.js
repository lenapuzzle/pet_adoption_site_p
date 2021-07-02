import React from 'react'

const HomeStatusField = props => {
  const homeStatuses = ["", "Rent", "Own"]

  const homeStatusOptions = homeStatuses.map(status => {
    return(
      <option key={status} value={status}>
        {status}
      </option>
    ) 
  })

  return(
    <div>
      <label htmlFor="homeStatus">Home Status:</label>
      <select name="homeStatus" id="homeStatus" onChange={props.handleInputChange} value={props.homeStatus}>
        {homeStatusOptions}
      </select>
    </div>
  )
}

export default HomeStatusField