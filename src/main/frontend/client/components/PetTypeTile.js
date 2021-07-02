import React from 'react'

const PetTypeTile = (props) => {
  const { id, name, imgUrl, description } = props.petType

  let descriptionTag;
  if(description) {
    descriptionTag = <p>{description}</p>
  }

  return (
    <div>
      <a href={`/pet-types/${id}`}>
        <img src={imgUrl} width="30%" />
        <h1>{name}</h1>
      </a>
      {descriptionTag}
    </div>
  )
}

export default PetTypeTile