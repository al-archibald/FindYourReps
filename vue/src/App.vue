<template>
  <div id="app">

<!-- ======= Header ======= -->
  <header class="header" id="myHeader">
    <div class="container">
      <div id="right-btn">
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">
        <a class="home-btn">Logout</a>
      </router-link>
      </div>
    </div>
  </header>
    <div id="main">
      <router-view id="main_view"/>
    </div>
    
</div>
</template>

<script>

export default {

data() {
    return {
      currentUser: {
        username: ''
      }
    }
},

}
</script>


<style>
@import url('https://fonts.googleapis.com/css2?family=Bebas+Neue&display=swap');

/*--------------------------------------------------------------
# General
--------------------------------------------------------------*/

body {
  background-size: cover;
  background-repeat: no-repeat;
  background-attachment: fixed;
  padding: 0;
}

a {
  color: #b40505;
  text-decoration: none;
}

a:hover {
  color: #070707;
  text-decoration: none;
}

h1,
h2,
h3,
h4,
h5,
h6 {
  font-family: 'Bebas Neue', sans-serif;
}

/*--------------------------------------------------------------
# Header
--------------------------------------------------------------*/

.header {
  background: #080808;
  transition: all 0.5s;
  z-index: 997;
  /* padding: 25px 0; */
  /* top: 20px; */
  width: 100%;
  margin: 0;
  padding: 0;
  position: fixed;
  width: 100%;
  transition: 0.2s; 
}

.container {
  margin: 0px;
  padding: 0;
  line-height: 1;
  font-weight: 300;
  letter-spacing: 1px;
  width: 100%;
  display: flex;
  flex-direction: row;
  justify-content: right;
}

#right-btn{
  margin-bottom: 20px;
  margin-right: 20px;
  margin-top: 20px;
  display: flex;
  justify-content: right;
  align-items: flex-end;
  width: 33%;
}

.header.header-scrolled {
  top: 0;
  background: rgba(0, 0, 0, 0.85);
  border-bottom: 1px solid #37332a;
}

.header .container {
  max-height: 100px;
}


/*--------------------------------------------------------------
# Home button Menu
--------------------------------------------------------------*/

.home-btn {
  font-family: "mencken-std", sans-serif;
  font-weight: 500;
  font-style: normal;
  margin-top: 20px;
  border: 2px solid #ffffff;
  color: #fff;
  border-radius: 50px;
  padding: 8px 25px;
  text-transform: uppercase;
  font-size: 13px;
  letter-spacing: 1px;
  transition: 0.3s;
}

.home-btn:hover {
  background: white; 
  color: rgb(241, 7, 7);
}

@media (max-width: 992px) {
  .home-btn {
    margin: 0 15px 0 0;
    padding: 8px 20px;
  }
}

/*--------------------------------------------------------------
# Main Section
--------------------------------------------------------------*/
#main {
  width: 100%; 
  height: 100vh;
  display: flex;
  justify-content: center;
  background: rgb(255, 255, 255);
}

#main:before {
  content: "";
  position: absolute;
  bottom: 0;
  /* top: 75px ; */
  left: 0;
  right: 0;
}

@media (max-width: 992px) {
  #main_view .container {
    padding-top: 98px;
  }
}

#main h1 {
  font-family: 'Bebas Neue', sans-serif;
  font-weight: 400;
  font-style: bold;
  margin-bottom: 0;
  font-size: 100px;
  line-height: 56px;
  color: #b40a0a;
  font-display:auto;
  font-stretch:normal;
}

#main h2 {
  font-family:'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  font-weight: 400;
  font-style: normal;
  font-display:auto;
  font-stretch:normal;
  color: #c00909;
  margin-bottom: 10px 0 0 0;
  font-size: 20px;
  text-align: center;
}

#main h3 {
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  font-display:auto;
  font-style:italic;
  font-weight:400;
  font-stretch:normal;
  color: #ffffff;
  margin-bottom: 10px 0 0 0;
  font-size: 30px;
}

#main p {
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  font-style: normal;
  font-display:auto;
  font-stretch:normal;
  color: #ffffff;
  margin-bottom: 10px 0 0 0;
  font-size: 20px;
}

#main_view {
  bottom: 0;
  top: 85px ;
  left: 0;
  right: 0;
  width: 100%;
  height: 100vh;
  display: flex;
  flex-direction: column;
  position: absolute;
}

.main_view_item {
  padding: 20px;
  width: 100%;
  display: flex;
  justify-content: center;
  /* position: relative; */
}

/* General Button Style */
.btn2 {
  font-family: "mencken-std", sans-serif;
  font-weight: 400;
  font-style: normal;
  margin: 0 0 0 15px;
  border: 2px solid #96c5ea;
  color: #fff;
  border-radius: 50px;
  padding: 8px 25px;
  text-transform: uppercase;
  font-size: 13px;
  letter-spacing: 1px;
  transition: 0.3s;
}

.btn2:hover {
 /* background: #cda45e; */
  color: #e37d43;
}

@keyframes breath {
  0% {
    transform: scaleX(1); }
  100% {
    transform: scaleX(0.95); } }

@keyframes breath2 {
  0% {
    transform: skewX(-10deg) scaleX(1); }
  100% {
    transform: skewX(-10deg) scaleX(0.95); } }



</style>