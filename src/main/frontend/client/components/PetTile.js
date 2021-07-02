import React from 'react'

const PetTile = (props) => {
  const { id, name, imgUrl, age, vaccinationStatus } = props.pet

  let vaccinationStatusText = "No";
  if(vaccinationStatus) {
    vaccinationStatusText = "Yes"
  }

  return (
    <div>
      <a href={`/pets/${id}`}>
        <img src={imgUrl} width="20%" />
        <h1>{name}</h1>
      </a>
      <p><strong>Age: </strong>{age}</p>
      <p><strong>Vaccinated?: </strong>{vaccinationStatusText}</p>
    </div>
  )
}

export default PetTile