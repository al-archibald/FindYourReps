<template>
  <div id="register" class="text-center">
    <form @submit.prevent="register">
      <h1>Create Account</h1>
      <div class="alert" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <div class="registration-form">
      <div class="form-input-group" >
        <label for="username" >Username</label>
        <input type="text" id="username" v-model="user.username" required autofocus />
      </div>
      <div class="form-input-group">
        <label for="password">Password</label>
        <input type="password" id="password" v-model="user.password" required />
      </div>
      <div class="form-input-group">
        <label for="confirmPassword">Confirm Password</label>
        <input type="password" id="confirmPassword" v-model="user.confirmPassword" required />
      </div>
      <div class="form-input-group">
        <label for="emailAddress">Email Address</label>
        <input type="text" id="emailAddress" v-model="user.emailAddress" required autofocus />
      </div>
      <div class="nav-btns">
        <button class="btn2" type="submit">Create Account</button>
        <router-link :to="{ name: 'login' }">
          <button class="btn2" type="button">Already have an account? Log in.</button> 
        </router-link>
      </div>
      </div>
    </form>
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
        emailAddress: ''
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style scoped>

.form-input-group {
  margin-bottom: 1rem;
  font-size: 150%;
  width: 800px;
  display: flex;
  justify-content: space-between;
  font-family: "mencken-std", sans-serif;
}

label {
  margin-right: 0.5rem;
}

input {
  width: 70%;
}

textarea {
  width: 70%;
  height: 75px
}

.nav-btns {
  display: flex;
  justify-content: left;
  margin-left: 16%;
}

.btn2 {
  font-family: "mencken-std", sans-serif;
  font-weight: 400;
  font-style: normal;
  color: #030303;
  margin: 0 0 0 15px;
  border: 2px solid #030303;
  border-radius: 50px;
  padding: 8px 25px;
  text-transform: uppercase;
  font-size: 13px;
  letter-spacing: 1px;
  transition: 0.3s;
  background: #fc020265;
}

.btn2:hover {
  background: #fcfcfc; 
  color: #fc0202;
}

div {
  align-items: center;
}

div .registration-form {
    align-items: center;
    justify-items: center;
    justify-content: center;
    padding: 30px;
}

h1 {
  text-align: center;
}

</style>