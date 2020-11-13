import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import Permit from "../views/Permit.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/permit",
    name: "Permit",
    component: Permit,
  },
];

const router = new VueRouter({
  routes,
});

export default router;
