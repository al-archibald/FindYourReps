<template>
<div class="main_view">

    <div class="main_view_item">
        <h1>Find Your Reps</h1>
    </div>

    <div class="subhead">
      <h2>Search your local, state, and national representatives.</h2>
      <h2>Retrieve reps' contact information including names,</h2>
      <h2>phone numbers, political parties, and email addresses.</h2>
    </div>


<!-- None of this is correct -->
    <div class="main_view_item">
      <router-link v-bind:to="{ name: 'SearchBox.vue' }">
        <a class="btn2">Search</a>
      </router-link>
    </div>

    <div class="main_view_item">
      <search-box-component/>
    </div>

  </div>

</template>

<script>


</script>