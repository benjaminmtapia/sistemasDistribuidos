<template>
  <v-container>
    <v-app-bar
      absolute
      color="#fcb69f"
      dark
      src="https://picsum.photos/1920/1080?random"
    >
      <template v-slot:img="{ props }">
        <v-img
          v-bind="props"
          gradient="to top right, rgba(19,84,122,.5), rgba(128,208,199,.8)"
        ></v-img>
      </template>

      <v-toolbar-title>Comisaría Virtual</v-toolbar-title>

      <v-spacer></v-spacer>
    </v-app-bar>
    <v-sheet
      id="scrolling-techniques-2"
      class="overflow-y-auto"
      max-height="1000"
    >
      <v-container style="margin-top: 200px; align: center;">
        <v-form class="form" ref="form" v-model="valid" lazy-validation>
          <v-text class="text">
            Solicitud de permiso temporal
          </v-text>
          <v-text-field
            v-model="model.name"
            :counter="30"
            :rules="nameRules"
            label="Nombre completo"
            required
          ></v-text-field>

          <v-text-field
            v-model="model.run"
            :counter="10"
            :rules="runRules"
            label="Rut"
            hint="sin puntos y con guión"
            required
          ></v-text-field>

          <v-text-field
            v-model="model.email"
            :rules="emailRules"
            label="Correo electrónico"
            required
          ></v-text-field>

          <v-text-field
            v-model="model.address"
            :rules="addressRules"
            label="Dirección"
            required
          ></v-text-field>

          <v-textarea
            counter
            v-model="model.reason"
            name="Reason"
            label="Motivo"
            hint="200 caracteres como máximo"
            required
          ></v-textarea>

          <v-checkbox
            v-model="checkbox"
            :rules="[(v) => !!v || 'Debes aceptar para continuar']"
            label="Declaro que esta información es real"
            required
          ></v-checkbox>

          <v-btn
            :disabled="!valid"
            color="success"
            class="mr-4"
            @click="validate"
          >
            Solicitar permiso
          </v-btn>

          <v-btn color="error" class="mr-4" @click="reset">
            Borrar formulario
          </v-btn>

          <v-btn to="/" class="mr-4" color="primary">
            volver
          </v-btn>
        </v-form>
      </v-container>
    </v-sheet>
  </v-container>
</template>

<script>
export default {
  data: () => ({
    model: {
      name: "",
      run: "",
      address: "",
      email: "",
      reason: "",
    },
  }),
  methods: {
    reset() {
      this.model.name = "";
      this.model.address = "";
      this.model.run = "";
      this.model.email = "";
      this.model.reason = "";
    },
  },
};
</script>
<style>
.form {
  margin-right: 30%;
  margin-left: 30%;
}
.text {
  text-align: center;
  font-size: 30px;
  margin-bottom: 30px;
}
.btn {
  margin-top: 10px;
  margin-bottom: 20px;
}
</style>
