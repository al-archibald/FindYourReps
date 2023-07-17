<template>
    <div>
        <input type="text" v-model="searchQuery" placeholder="Search for your representative">
        <button @click="search">Search</button>

        <ul> 
            <li v-for="result in searchResults" :key="result.id">
                {{ result.name }}
            </li>
        </ul>
    </div>
</template>


<script>

import axios from 'axios';
export default {
    data() {
        return {
            searchQuery: '',
            searchResults: []
        };
    },
methods: {
    search() {
        axios.get('/getName', {
            params: {
                searchQuery: this.searchQuery
            }
        })
        .then(response => {
            console.log(response.data);
        })
        .catch(error => {
            console.error(error);
        });
    }
}
}
</script>