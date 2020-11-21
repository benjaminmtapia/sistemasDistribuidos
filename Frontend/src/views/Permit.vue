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
          <h1 class="text">
            Solicitud de permiso temporal
          </h1>
          <v-text-field
            v-model="model.name"
            :counter="30"
            label="Nombre completo"
            required
          ></v-text-field>

          <v-text-field
            v-model="model.run"
            :counter="10"
            label="Rut"
            hint="sin puntos y con guión"
            required
          ></v-text-field>

          <v-text-field
            v-model="model.email"
            label="Correo electrónico"
            required
          ></v-text-field>

          <v-text-field
            v-model="model.address"
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
            label="Declaro que esta información es real"
            required
          ></v-checkbox>

          <v-btn
            :disabled="!valid"
            color="success"
            class="mr-4"
            @click="requestPermit"
          >
            Solicitar permiso
          </v-btn>

          <v-btn color="error" class="mr-4" @click="reset">
            Borrar formulario
          </v-btn>

          <v-btn to="/" class="mr-4" color="primary">
            volver
          </v-btn>
          <p class="successText" v-if="successMessage">
            {{ message }}
          </p>
          <p class="errorText" v-if="errorMessage">
            {{ message }}
          </p>
        </v-form>
      </v-container>
    </v-sheet>
  </v-container>
</template>

<script>
export default {
  data: () => ({
    model: {
      run: "",
      name: "",
      address: "",
      reason: "",
      email: "",
    },
    valid: true,
    checkbox: false,
    successMessage: false,
    errorMessage: false,
    message: "",
  }),
  methods: {
    reset() {
      this.model.name = "";
      this.model.address = "";
      this.model.run = "";
      this.model.email = "";
      this.model.reason = "";
    },
    requestPermit() {
      this.message = "";
      this.successMessage = false;
      this.errorMessage = false;
      fetch("http://localhost:9090/forms/add", {
        method: "POST",
        mode: 'cors',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(this.model),
      })
        .then(() => {
          this.message = "Éxito al pedir formulario.";
          this.successMessage = true;
        })
        .catch((error) => {
          console.log(error);
          this.message = "Error al enviar solicitud.";
          this.errorMessage = true;
        });
      
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
.errorText {
  color: red;
}
.successText {
  color: green;
}
</style>
