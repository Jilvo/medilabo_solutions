import { createRouter, createWebHistory } from 'vue-router'
import Patients from '../views/Patients.vue'

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Patients
  }
]

const router = createRouter({
  history: createWebHistory('/'),
  routes
})

export default router
