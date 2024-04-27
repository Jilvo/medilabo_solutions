<template>
  <div
    v-if="show"
    class="fixed z-50 inset-0 overflow-y-auto flex items-center justify-center bg-black bg-opacity-50"
  >
    <div class="bg-white rounded-lg px-4 pt-5 pb-4 sm:p-6 sm:pb-4">
      <div class="sm:flex flex-col">
        <div class="flex justify-between">
          <h3 class="text-lg leading-6 font-medium text-gray-900 mb-2" id="modal-title">
            Modifier le Patient
          </h3>
          <div class="relative">
            <button @click="close" class="absolute top-0 right-0 bg-white rounded-full p-1">
              <svg
                class="h-6 w-6 text-gray-400 hover:text-gray-500"
                xmlns="http://www.w3.org/2000/svg"
                fill="none"
                viewBox="0 0 24 24"
                stroke="currentColor"
                aria-hidden="true"
              >
                <path
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  stroke-width="2"
                  d="M6 18L18 6M6 6l12 12"
                />
              </svg>
            </button>
          </div>
        </div>
        <div class="mt-3 text-center sm:mt-0 sm:text-left w-full">
          <form class="w-full max-w-lg">
            <div class="flex flex-wrap -mx-3 mb-6">
              <div class="w-full md:w-1/2 px-3 mb-6 md:mb-0">
                <label
                  class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2"
                  for="grid-first-name"
                >
                  Prénom
                </label>
                <input
                  class="appearance-none block w-full bg-gray-200 text-gray-700 border rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white"
                  id="grid-first-name"
                  type="text"
                  v-bind:class="{ 'border-red-500': errors.firstName }"
                  :placeholder="patient.firstName"
                  v-model="localPatient.firstName"
                />
                <p class="text-red-500 text-xs italic">{{ errors.firstName }}</p>
              </div>
              <div class="w-full md:w-1/2 px-3">
                <label
                  class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2"
                  for="grid-last-name"
                >
                  Nom de Famille
                </label>
                <input
                  class="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                  id="grid-last-name"
                  type="text"
                  v-bind:class="{ 'border-red-500': errors.lastName }"
                  :placeholder="patient.lastName"
                  v-model="localPatient.lastName"
                />
                <p class="text-red-500 text-xs italic">{{ errors.lastName }}</p>
              </div>
            </div>
            <div class="flex flex-wrap -mx-3 mb-6">
              <div class="w-full px-3">
                <label
                  class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2"
                  for="grid-password"
                >
                  Adresse
                </label>
                <input
                  class="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                  id="grid-password"
                  type="text"
                  v-bind:class="{ 'border-red-500': errors.address }"
                  :placeholder="patient.address"
                  v-model="localPatient.address"
                />
                <p class="text-red-500 text-xs italic">{{ errors.address }}</p>
              </div>
            </div>
            <div class="flex flex-wrap -mx-3 mb-2">
              <div class="w-full md:w-1/3 px-3 mb-6 md:mb-0">
                <label
                  class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2"
                  for="grid-city"
                >
                  Numéro de téléphone
                </label>
                <input
                  class="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                  id="grid-city"
                  type="text"
                  v-bind:class="{ 'border-red-500': errors.phone }"
                  :placeholder="patient.phone"
                  v-model="localPatient.phone"
                />
                <p class="text-red-500 text-xs italic">{{ errors.phone }}</p>
              </div>
              <div class="w-full md:w-1/3 px-3 mb-6 md:mb-0">
                <label
                  class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2"
                  for="grid-state"
                >
                  Genre
                </label>
                <div class="relative">
                  <select
                    class="block appearance-none w-full bg-gray-200 border border-gray-200 text-gray-700 py-3 px-4 pr-8 rounded leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                    id="grid-state"
                    v-model="localPatient.gender"
                  >
                    <option>M</option>
                    <option>F</option>
                  </select>
                  <div
                    class="pointer-events-none absolute inset-y-0 right-0 flex items-center px-2 text-gray-700"
                  >
                    <svg
                      class="fill-current h-4 w-4"
                      xmlns="http://www.w3.org/2000/svg"
                      viewBox="0 0 20 20"
                    >
                      <path
                        d="M9.293 12.95l.707.707L15.657 8l-1.414-1.414L10 10.828 5.757 6.586 4.343 8z"
                      />
                    </svg>
                  </div>
                </div>
              </div>
              <div class="w-full md:w-1/3 px-3 mb-6 md:mb-0">
                <label
                  class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2"
                  for="grid-zip"
                >
                  Date de naissance
                </label>
                <input
                  class="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                  id="grid-zip"
                  type="text"
                  v-bind:class="{ 'border-red-500': errors.birthDate }"
                  :placeholder="patient.birthDate"
                  v-model="localPatient.birthDate"
                />
                <p class="text-red-500 text-xs italic">{{ errors.birthDate }}</p>
              </div>
            </div>
          </form>
        </div>
        <button
          class="bg-gradient-to-r from-blue-400 to-blue-600 text-white py-2 px-4 rounded hover:bg-blue-600 focus:outline-none focus:ring-2 focus:ring-blue-600 focus:ring-opacity-50"
          @click="validateInput()"
        >
          Mettre à jour le dossier du patient
        </button>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  data() {
    return {
      localPatient: {
        firstName: '',
        lastName: '',
        address: '',
        phone: '',
        gender: 'M',
        birthDate: ''
      },
      errors: {
        firstName: null,
        lastName: null,
        address: null,
        phone: null,
        gender: null,
        birthDate: null
      }
    }
  },
  props: ['show', 'patient'],
  watch: {
    patient: {
      handler(newValue) {
        this.localPatient = { ...newValue }
      },
      deep: true
    }
  },
  methods: {
    close() {
      this.$emit('close')
    },
    async validateInput() {
      // console.log('Checking input datas')
      // console.log('Patient:', this.patient)
      const is_number = /^[0-9]*$/
      const is_only_letter = /^[a-zA-Z]*$/

      this.errors.firstName =
        !this.localPatient.firstName || !is_only_letter.test(this.localPatient.firstName)
          ? 'Le prénom est invalide. Il doit contenir que des lettres.'
          : null

      this.errors.lastName =
        !this.localPatient.lastName || !is_only_letter.test(this.localPatient.lastName)
          ? 'Le nom est invalide. Il doit contenir que des lettres.'
          : null

      this.errors.address = !this.localPatient.address ? "L'adresse est invalide." : null

      this.errors.phone =
        !this.localPatient.phone || !is_number.test(this.localPatient.phone)
          ? 'Le numéro de téléphone est invalide. Il doit contenir que des chiffres.'
          : null

      this.errors.gender = !this.localPatient.gender ? 'Le genre est invalide.' : null

      this.errors.birthDate = !this.localPatient.birthDate
        ? 'La date de naissance est invalide.'
        : null
      console.log('LOCAL', this.localPatient)
      if (!Object.values(this.errors).every((x) => x === null)) {
        console.log(this.errors)
      } else {
        console.log(this.localPatient)
        this.updatePatient()
        this.$emit('close')
      }
    },
    async updatePatient() {
      console.log('Creating patient:', this.localPatient)
      console.log('Creating patient id:', this.patient.id)
      try {
        const response = await axios.put(
          'http://localhost:9000/api/patients/' + this.patient.id,
          this.localPatient
        )
        this.patients = response.data
        console.log('Patients:', this.patients)
      } catch (error) {
        console.error("Une erreur s'est produite lors de la création du patient :", error)
      }
    }
  }
}
</script>
