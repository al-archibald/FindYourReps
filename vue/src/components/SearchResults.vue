<template>
  <div class="rep_table">
    <table class="table" data-classes="table table-hover table-condensed">
      <thead>
        <tr class="columns">
          <th>NAME</th>
          <th>PHONE</th>
          <th>PARTY</th>
          <th>EMAIL</th>
        </tr>
      </thead>
      <tbody>
        <tr class="info" v-for="result in displayedResults" :key="result.id">
          <td class="results">{{ result.name }}</td>
          <td class="results">{{ result.phone }}</td>
          <td class="results">{{ result.party }}</td>
          <td class="results">{{ result.email }}</td>
        </tr>
      </tbody>
    </table>
    <div class="pagination">
      <button @click="previousPage" :disabled="currentPage === 1">
        Previous
      </button>
      <button @click="nextPage" :disabled="currentPage === totalPages">
        Next
      </button>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    results: {
      type: Array,
      required: true,
    },
    pageSize: {
      type: Number,
      default: 5,
    },
  },
  data() {
    return {
      currentPage: 1,
    };
  },
  computed: {
    totalPages() {
      return Math.ceil(this.results.length / this.pageSize);
    },
    displayedResults() {
      const startIndex = (this.currentPage - 1) * this.pageSize;
      const endIndex = startIndex + this.pageSize;
      return this.results.slice(startIndex, endIndex);
    },
  },
  methods: {
    previousPage() {
      if (this.currentPage > 1) {
        this.currentPage--;
      }
    },
    nextPage() {
      if (this.currentPage < this.totalPages) {
        this.currentPage++;
      }
    },
  },
};
</script>

<style scoped>
.rep_table {
  align-items: center;
  text-align: left;
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
}

.table {
  border: 1px solid #000000;
  width: 75%;
  border-spacing: 0px;
  border-collapse: collapse;
  table-layout: fixed;
  margin-left: auto;
  margin-right: auto;
  padding: 10px;
  margin-top: 25px;
  font-family: "mencken-std", sans-serif;
}

.columns th,
.results td {
  text-align: left;
  color: rgb(0, 0, 0);
  background: rgba(255, 17, 0, 0.308);
  border-color: #000000;
  border: 1px solid;
  padding: 8px;
}

.results {
  text-align: left;
  color: rgb(2, 2, 2);
  background: #ffffff;
  border: 1px solid;
  padding: 10px;
  font-size: 12px;
}

.results:hover {
  background-color: #cacaca96;
}

.pagination {
  display: flex;
  justify-content: center;
  padding: 20px;
}
</style>