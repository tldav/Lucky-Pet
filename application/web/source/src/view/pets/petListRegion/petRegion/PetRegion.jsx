function PetRegion({ pet }) {
  const renderPet = () => {
    return <p className="pet-name">{pet.name} </p>;
  };

  return <div className="pet-region">{renderPet()}</div>;
}

export default PetRegion;
