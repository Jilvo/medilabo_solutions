<template>
  <div
    v-if="show"
    class="fixed z-50 inset-0 overflow-y-auto flex items-center justify-center bg-black bg-opacity-50"
  >
    <div class="bg-white rounded-lg px-4 pt-5 pb-4 sm:p-6 sm:pb-4 w-3/4 2xl:w-1/2">
      <div class="sm:flex flex-col">
        <div class="flex justify-between">
          <h3 class="text-lg leading-6 font-medium text-gray-900 mb-2" id="modal-title">
            <p>Les notes de {{ this.patientName }}</p>
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
        <div v-if="createNoteModal">
          <button
            class="bg-gradient-to-r from-yellow-400 to-yellow-600 text-white py-2 px-4 rounded hover:bg-green-600 w-full focus:outline-none focus:ring-2 focus:ring-green-600 focus:ring-opacity-50"
            @click="openListNoteModal"
          >
            Retourner à la liste des mémos
          </button>
        </div>
        <div v-else>
          <button
            class="bg-gradient-to-r from-green-400 to-green-600 text-white py-2 px-4 rounded hover:bg-green-600 w-full focus:outline-none focus:ring-2 focus:ring-green-600 focus:ring-opacity-50"
            @click="openCreateNoteModal"
          >
            Créer une nouvelle note
          </button>
        </div>
        <div v-if="error" class="error">{{ error }}</div>
        <div v-if="createNoteModal">
          <div v-if="createNoteModal">
            <div class="flex w-full md:w-1/2 px-3 mb-6 md:mb-0 pt-10">
              <label
                class="uppercase tracking-wide text-gray-700 text-xs font-bold mb-2 mr-3 self-center"
              >
                Note
              </label>
              <input
                class="flex-grow appearance-none bg-gray-200 text-gray-700 border rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white"
                id="grid-first-name"
                type="text"
                v-bind:class="{ 'border-red-500': errors }"
                placeholder="Memo"
                v-model="note"
              />
            </div>
            <p class="text-red-500 text-xs italic">{{ errors }}</p>
            <button
              class="bg-gradient-to-r from-green-400 to-green-600 text-white py-2 px-4 rounded hover:bg-green-600 w-full focus:outline-none focus:ring-2 focus:ring-green-600 focus:ring-opacity-50"
              @click="validateInput()"
            >
              Enregistrer Mémo
            </button>
          </div>
        </div>
        <div v-else>
          <div v-for="note in this.notes" :key="note.id" class="pt-3 flex justify-around">
            <p class="flex-grow whitespace-pre-wrap">{{ note.note }}</p>
            <button
              class="bg-gradient-to-r from-blue-400 to-blue-600 text-white py-2 px-4 rounded hover:bg-blue-600 focus:outline-none focus:ring-2 focus:ring-blue-600 focus:ring-opacity-50"
              @click="deleteNote(note.id)"
            >
              Supprimer la Note
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  data() {
    return {
      note: '',
      notes: [],
      error: '',
      createNoteModal: false
    }
  },
  props: ['show', 'patientId', 'patientName'],
  methods: {
    close() {
      this.createNoteModal = false
      if (this.createNoteModal) {
        this.createNoteModal = false
        this.showCreateNoteModal = true
        this.$emit('close')
      } else {
        this.$emit('close')
      }
      //   this.$emit('close')
    },
    async getAllNotesOfPatient(id) {
      try {
        const response = await axios.get(`http://localhost:9001/notes/patId/${id}`)
        this.notes = response.data
      } catch (error) {
        console.error(error)
      }
    },
    openCreateNoteModal() {
      this.createNoteModal = true
    },
    openListNoteModal() {
      this.createNoteModal = false
    },
    async saveNote() {
      try {
        let data = {
          patId: this.patientId,
          patient: this.patientName,
          note: this.note
        }
        console.log('VANT ENVOI', data)
        const response = await axios.post(`http://localhost:9001/notes`, data)
        console.log(response)
        this.createNoteModal = false
        this.getAllNotesOfPatient(this.patientId)
        this.note = ''
      } catch (error) {
        console.error(error)
      }
    },
    async validateInput() {
      if (this.note === '') {
        this.error = 'Le champ ne peut pas être vide'
      } else {
        this.error = ''
        this.saveNote()
      }
    },
    async deleteNote(id) {
      try {
        console.log('test')
        const response = await axios.delete(`http://localhost:9001/notes/${id}`)
        console.log(response)
        this.notes = this.notes.filter((note) => note.id !== id)
      } catch (error) {
        console.error(error)
      }
    },
    async createdNote() {
      this.createNoteModal = true
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
