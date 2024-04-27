<template>
  <div
    v-if="show"
    class="fixed z-50 inset-0 overflow-y-auto flex items-center justify-center bg-black bg-opacity-50"
  >
    <div class="bg-white rounded-lg px-4 pt-5 pb-4 sm:p-6 sm:pb-4">
      <div class="sm:flex flex-col">
        <div class="flex justify-between">
          <h3 class="text-lg leading-6 font-medium text-gray-900 mb-2" id="modal-title">
            <p>Les notes de {{ this.patientName }}</p>
          </h3>
          <button
            class="bg-gradient-to-r from-green-400 to-green-600 text-white py-2 px-4 rounded hover:bg-green-600 focus:outline-none focus:ring-2 focus:ring-green-600 focus:ring-opacity-50"
            @click="openCreateNoteModal"
          >
            Créer une nouvelle note
          </button>
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

        <div v-if="error" class="error">{{ error }}</div>
        <div v-for="note in this.notes" :key="note.id">
          {{ note.note }}
          <button
            class="bg-gradient-to-r from-blue-400 to-blue-600 text-white py-2 px-4 rounded hover:bg-blue-600 focus:outline-none focus:ring-2 focus:ring-blue-600 focus:ring-opacity-50"
            @click="deleteNote(note.id)"
          >
            Supprimer la Note
          </button>
        </div>
        <!-- <button
              class="bg-gradient-to-r from-green-400 to-green-600 text-white py-2 px-4 rounded hover:bg-green-600 focus:outline-none focus:ring-2 focus:ring-green-600 focus:ring-opacity-50"
              @click="validateInput(patient)"
            >
              Créer une nouvelle note
            </button> -->
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  data() {
    return { notes: [], error: '', patientName: '' }
  },
  props: ['show', 'patientId'],
  methods: {
    close() {
      this.$emit('close')
    },
    async getAllNotesOfPatient(id) {
      try {
        const response = await axios.get(`http://localhost:9001/notes/patId/${id}`)
        this.notes = response.data
        this.patientName = response.data[0].patient.patient
      } catch (error) {
        console.error(error)
      }
    },
    openCreateNoteModal() {
      this.$emit('openCreateNoteModal')
    },
    async deleteNote(id) {
      try {
        const response = await axios.delete(`http://localhost:9001/notes/${id}`)
        this.notes = this.notes.filter((note) => note.id !== id)
      } catch (error) {
        console.error(error)
      }
    }
  },
  watch: {
    show(newVal) {
      if (newVal) {
        this.getAllNotesOfPatient(this.patientId)
      }
    }
  }
}
</script>
