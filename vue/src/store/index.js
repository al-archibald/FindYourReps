import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
* The authorization header is set for axios at login.
* When the page is refreshed, it checks for the token in 
* local storage and if it exists, the header is set so
* that it will be attached to each request.
*/

const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '', /* set token = token from local store or empty String */
    user: currentUser || {} /* set user = current user or empty object */
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token'); /* at logout, the token and user are */
      localStorage.removeItem('user'); /* removed from local storage */
      state.token = ''; /* set token back to empty String */ 
      state.user = {}; /* set user back to empty object */
      axios.defaults.headers.common = {}; /* remove bearer token from axios header */
    }
  }
})
