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
      max-height="800"
    >
      <v-container style="margin-top: 200px; align: center;">
        <v-form class="form" ref="form" v-model="valid" lazy-validation>
          <v-text class="formTitle">
            Solicitud de permiso temporal
          </v-text>
          <v-text-field
            v-model="name"
            :counter="10"
            :rules="nameRules"
            label="Name"
            required
          ></v-text-field>

          <v-text-field
            v-model="rut"
            :counter="9"
            :rules="runRules"
            label="Rut"
            required
          ></v-text-field>

          <v-text-field
            v-model="email"
            :rules="emailRules"
            label="E-mail"
            required
          ></v-text-field>

          <v-textarea
            counter
            name="Reason"
            label="Motivo"
            rules="reasonRules"
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
            Validate
          </v-btn>

          <v-btn color="error" class="mr-4" @click="reset">
            Reset Form
          </v-btn>

          <v-btn color="warning" @click="resetValidation">
            Reset Validation
          </v-btn>
        </v-form>
      </v-container>
    </v-sheet>
  </v-container>
</template>

<script>
export default {
  data: () => ({
    reasonRules: [(v) => v.length <= 200 || "Máximo 200 caracteres"],
  }),
};
</script>
<style>
.form {
  margin-right: 30%;
  margin-left: 30%;
}
.formTitle {
  font-size: 25;
  text-align: center;
}
</style>
