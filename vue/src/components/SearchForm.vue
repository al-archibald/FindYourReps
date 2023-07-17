<template>
  <div class="search-input">
    <form @submit.prevent="submitSearch">
      <input
        type="text"
        v-model="searchQuery"
        placeholder="Search Representatives..."
      />
      <button type="submit">Search</button>
    </form>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      searchQuery: "",
    };
  },

  methods: {
    async submitSearch() {
      try {
        const response = await axios.get(
          "localhost:9000/searchName?query=?&page=0&size=5&sort=name&direction=asc",
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
  },
};
</script>




<style scoped>
div.search-input {
  padding: 25px;
  display: flex;
  justify-content: center;
}
</style>