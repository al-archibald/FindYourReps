<template>
  <div class="search-input">
    <form @submit.prevent="submitSearch">
      <input
        type="text"
        v-model="searchQuery"
        placeholder="Search Representatives..."
      />
      <button type="submit">Search</button>
      <div role="alert" v-if="errorMessage" class="error-message">
      {{ errorMessage }} </div>
    </form>
  </div>

</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      searchQuery: "",
      errorMessage:"",
    };
  },

  methods: {
    async submitSearch() {
      // ensure searchQuery is entered with valid characters
      if (!this.isValidSearchQuery(this.searchQuery)) {
        this.errorMessage = "Invalid search. Please enter letters.";
        return;
      }

      // once valid characters are entered, error message disappears
      this.errorMessage = "";

      try {
        const response = await axios.get(
          "/searchName",
          {
            params: {
              query: this.searchQuery,
              page: 0,
              size: 5,
              sort: "name",
              direction: "asc",
            },
          }
        );
        this.$emit("search-results", response.data);
      } catch (error) {
        console.error(error);
      }
    },

    isValidSearchQuery(searchQuery) {
      return /^[a-zA-Z]+$/.test(searchQuery);
    },
  },
};
</script>

<style scoped>

.error-message {
  padding-top: 15px;
  font-weight: bold;
  color: rgb(0, 0, 0);
  margin-top: 5px;
  font-size: 14px;
  font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
}

div.search-input {
  padding: 25px;
  display: flex;
  justify-content: center;
}

</style>