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

    <div class="search-form">
      <SearchForm @search-results="handleSearchResults" />
    </div>

    <div class="search-results">
      <SearchResults :results="SearchResults" />
    </div>

  </div>
</template>

<script>
import SearchForm from "../components/SearchForm.vue";
import SearchResults from "../components/SearchResults.vue";

export default {
  components: {
    SearchForm,
    SearchResults,
  },
  data() {
    return {
      SearchResults: [],
    };
  },
  methods: {
    handleSearchResults(results) {
      this.SearchResults = results;
    },
  },
};
</script>