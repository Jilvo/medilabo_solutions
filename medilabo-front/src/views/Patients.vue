<template>
  <Header msg="Header" />
  <div class="mt-10 flex justify-center">
    <div class="w-10/12 relative overflow-x-auto shadow-md sm:rounded-lg">
      <button
        class="bg-gradient-to-r from-green-400 to-green-600 text-white py-2 px-4 rounded hover:bg-green-600 mb-2 ocus:outline-none focus:ring-2 focus:ring-green-600 focus:ring-opacity-50"
        @click="newPatient()"
      >
        Créer un nouveau patient
      </button>
      <table class="w-full text-sm text-left rtl:text-right text-gray-500 dark:text-gray-400">
        <thead
          class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400"
        >
          <tr>
            <th scope="col" class="px-6 py-3">Prénom</th>
            <th class="px-6 py-3">Nom</th>
            <th class="px-6 py-3">Date de naissance</th>
            <th class="px-6 py-3">Téléphone</th>
            <th class="px-6 py-3">Genre</th>
            <th class="px-6 py-3">Adresse</th>
            <th class="px-6 py-3">Rapport</th>
            <th>Supprimer</th>
            <th>Modifier</th>
            <th>Créer Note</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="patient in patients" :key="patient.id">
            <td class="px-6 py-4">{{ patient.firstName }}</td>
            <td class="px-6 py-4">{{ patient.lastName }}</td>
            <td class="px-6 py-4">{{ patient.birthDate }}</td>
            <td class="px-6 py-4">{{ patient.phone }}</td>
            <td class="px-6 py-4">{{ patient.gender }}</td>
            <td class="px-6 py-4">{{ patient.address }}</td>
            <td class="px-6 py-4">{{ patient.report }}</td>
            <td>
              <button
                class="text-white py-2 px-4 rounded bg-gradient-to-r from-red-400 to-red-600 hover:bg-red-600 focus:outline-none focus:ring-2 focus:ring-red-600 focus:ring-opacity-50"
                @click="deletePatient(patient.id)"
              >
                Supprimer
              </button>
            </td>
            <td>
              <button
                class="bg-gradient-to-r from-blue-400 to-blue-600 text-white py-2 px-4 rounded hover:bg-blue-600 focus:outline-none focus:ring-2 focus:ring-blue-600 focus:ring-opacity-50"
                @click="editPatient(patient.id)"
              >
                Modifier
              </button>
            </td>
            <td>
              <button
                class="bg-gradient-to-r from-yellow-400 to-yellow-600 text-white py-2 px-4 rounded hover:bg-blue-600 focus:outline-none focus:ring-2 focus:ring-blue-600 focus:ring-opacity-50"
                @click="showNotesOfPatient(patient)"
              >
                Notes
              </button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
  <EditPatientModal
    :show="showEditModal"
    :patient="selectedPatient"
    @close="showEditModal = false"
  />
  <NewPatientModal :show="showNewModal" @close="showNewModal = false" />
  <ShowNotesModal
    :show="showNotesOfPatientModal"
    :patientId="selectedPatient"
    :patientName="selectedPatientName"
    @close="showNotesOfPatientModal = false"
  />
</template>

<script>
import Header from '../components/Header/Header.vue'
import EditPatientModal from '../components/Modal/EditPatientModal.vue'
import NewPatientModal from '../components/Modal/NewPatientModal.vue'
import ShowNotesModal from '../components/Modal/ShowNotesModal.vue'
import axios from 'axios'

export default {
  components: {
    // eslint-disable-next-line vue/no-reserved-component-names
    Header,
    EditPatientModal,
    NewPatientModal,
    ShowNotesModal
  },
  data() {
    return {
      patients: [],
      showEditModal: false,
      showNewModal: false,
      showNotesOfPatientModal: false,
      selectedPatient: null,
      selectedPatientName: null,
      showCreateNoteModal: false
    }
  },
  mounted() {
    this.fetchPatients()
  },
  methods: {
    async fetchPatients() {
      try {
        const response = await axios.get('http://localhost:9000/patients')
        this.patients = response.data
      } catch (error) {
        console.error("Une erreur s'est produite lors de la récupération des patients :", error)
      }
      for (const patient of this.patients) {
        let report = await this.fetchReports(patient)
        console.log(report)
        patient.report = report
      }
    },
    async fetchReports(patient) {
      try {
        const response = await axios.get('http://localhost:9002/report/' + patient.id)
        console.log(response.data.risk)
        let report = response.data.risk
        return report
      } catch (error) {
        console.error("Une erreur s'est produite lors de la récupération des rapports :", error)
      }
    },
    async newPatient() {
      this.selectedPatient = null
      this.showNewModal = true
      this.showEditModal = false
      this.showNotesOfPatientModal = false
    },
    async deletePatient(id) {
      try {
        await axios.delete(`http://localhost:9000/patients/${id}`)
        this.fetchPatients()
      } catch (error) {
        console.error("Une erreur s'est produite lors de la suppression du patient :", error)
      }
    },

    async editPatient(id) {
      const patient = this.patients.find((p) => p.id === id)
      this.selectedPatient = patient
      this.showEditModal = true
      this.showNewModal = false
      this.showNotesOfPatientModal = false
    },
    async showNotesOfPatient(patient) {
      this.selectedPatient = patient.id
      this.selectedPatientName = patient.firstName
      this.showEditModal = false
      this.showNewModal = false
      this.showNotesOfPatientModal = true
    }
  }
}
</script>
