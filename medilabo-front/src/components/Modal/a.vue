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
        </div>
      </div>
    </div>
  </div>
</template>

<script>
// import ShowNotesModal from './components/Modal/ShowNotesModal.vue'
// import NewNoteModal from './components/Modal/NewNoteModal.vue'

export default {
  components: {
    // ShowNotesModal,
    // NewNoteModal
  },
  data() {
    return {
      show: false,
      showNotes: true,
      patientId: null
    }
  },
  methods: {
    handleClose() {
      this.show = false
    },
    handleOpenCreateNoteModal() {
      this.showNotes = false
    },
    close() {
      this.$emit('close')
    }
  }
}
</script>
