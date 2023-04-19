import { handler } from '../../services/LuckyPetTable/Read'

const event = {
  body: {
    dogName: 'Fido',
    breed: 'pit-bull',
  },
}

handler({} as any, {} as any)
