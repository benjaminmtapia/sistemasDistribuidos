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
        <div class="text">
          Categoría de trámites
        </div>

        <v-card class="card" elevation="2">
          <v-card-title>Permisos temporales individuales</v-card-title>
          <v-card-text
            >Permisos individuales de circulación temporal para zonas en
            cuarentena</v-card-text
          >
          <v-btn to="/permit" class="btn" depressed color="primary">
            Ir a trámites
          </v-btn>
        </v-card>
      </v-container>
    </v-sheet>
  </v-container>
</template>

<script>
// @ is an alias to /src

export default {
  data: () => ({}),
};
</script>
<style>
.card {
  margin-left: 35%;
  margin-right: 35%;
}
.btn {
  margin-top: 50px;
  margin-left: 35px;
  margin-bottom: 30px;
}
.text {
  text-align: center;
  font-size: 30px;
  margin-bottom: 30px;
}
</style>
