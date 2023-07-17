import axios from 'axios';


<template>
    <div>
        <input type="text" v-model="searchQuery" placeholder="Search for your representative">
        <button @click="search">Search</button>
    </div>
</template>


<script>
export default {
    data() {
        return {
            searchQuery: ''
        };
    },

methods: {
    search() {
        console.log(this.searchQuery);
    }
}
}
</script>