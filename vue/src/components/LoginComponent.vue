<template>
  <div class="main_view_item">
    <form @submit.prevent="login">
      <h1>Please Sign In</h1>
      <div class="login">
      <div role="alert" v-if="invalidCredentials" id="invalid">
        Invalid username and password, please try again.
      </div>
      <div role="alert" v-if="this.$route.query.registration">
        Thank you for registering, please sign in.
      </div>
      <div class="form-input-group">
        <label for="username">Username</label>
        <input type="text" id="username" v-model="user.username" required autofocus />
      </div>
      <div class="form-input-group">
        <label for="password">Password</label>
        <input type="password" id="password" v-model="user.password" required />
      </div>
      <div class="center_align">
      <button class="btn2" type="submit">Sign in</button>
      </div>
      <p class="center_align">
      <router-link :to="{ name: 'register' }">Need an account? Sign up.</router-link>
      </p>
      </div>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};

</script>

<style scoped>
.form-input-group {
  margin-bottom: 1rem;
  color: red;

}
label {
  margin-right: 0.5rem;
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

label {
  font-family:'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  font-weight: 400;
  font-style: normal;
  font-display:auto;
  font-stretch:normal;
  text-transform: uppercase;
  color: #b40505;
  margin-bottom: 10px 0 0 0;
  font-size: 20px;
}

.center_align{
  display:flex;
  justify-content: center;
  padding-top: 10px;
}

div .login{
  color: white;
  font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
  padding-top: 60px;
}

.alert{
  font-family:'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  font-weight: 400;
  font-style: normal;
  font-display:auto;
  font-stretch:normal;
  text-transform: uppercase;
  color: #e37d43;
  margin-bottom: 10px 0 0 0;
  font-size: 20px;
}

</style>