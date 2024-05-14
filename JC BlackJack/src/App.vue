<template>
  <div>
    <header>

      <div class="wrapper">
        <h1 class="welcome-title">Welcome to JC Blackjack</h1>

        <nav>
          <RouterLink to="/" exact>Home</RouterLink>
          <RouterLink to="/about" exact>About</RouterLink>
        </nav>
      </div>
    </header>

    <RouterView />

    <div>
      <h2>Blackjack Strategies</h2>
      <MyList :items="strategies" />
    </div>
  </div>
</template>

<script setup lang="ts">
import { RouterLink, RouterView } from 'vue-router';
import MyList from './components/MyList.vue';

const strategies = ['Basic Strategy', 'Card Counting', 'Shuffle Tracking'];
</script>

<style scoped>
header {
  line-height: 1.5;
  max-height: 100vh;
}
div {
  background-image: url('/');
  background-size: cover;
  background-position: center;
}

.logo {
  display: block;
  margin: 0 auto 2rem;
}

.wrapper {
  display: flex;
  justify-content: space-between; /* Elemente in der header in einer Zeile platzieren */
  align-items: center; /* Elemente vertikal zentrieren */
  padding: 1rem;


}

nav {
  width: 100%;
  font-size: 12px;
  text-align: center;
  margin-top: 2rem;
}

nav a.router-link-exact-active {
  color: var(--color-text);
}

nav a.router-link-exact-active:hover {
  background-color: transparent;
}

nav a {
  display: inline-block;
  padding: 0 1rem;
  border-left: 1px solid var(--color-border);
}

nav a:first-of-type {
  border: 0;
}

@media (min-width: 1024px) {
  header {
    display: flex;
    place-items: center;
    padding-right: calc(var(--section-gap) / 2);
  }


  header .wrapper {
    display: flex;
    place-items: flex-start;
    flex-wrap: wrap;
  }

  nav {
    text-align: left;
    margin-left: -1rem;
    font-size: 1rem;
    padding: 1rem 0;
    margin-top: 1rem;
  }

}
</style>
