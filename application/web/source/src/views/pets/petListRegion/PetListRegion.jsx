import PetRegion from "./petRegion/PetRegion"
import pets from "../../../data/pet.json"

function PetListRegion() {
  const renderPets = () => {
    return pets.map((pet) => {
      return <PetRegion pet={pet} key={pet.name} />;
    });
  };

  return <div id="pet-list-region">{renderPets()}</div>;
}

export default PetListRegion;
