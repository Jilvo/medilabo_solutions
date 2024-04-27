<template>TEST</template>

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
    close() {
      this.$emit('close')
    }
  }
}
</script>
