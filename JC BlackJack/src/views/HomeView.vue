<template>
  <main>
    <TheWelcome />

    <div v-if="players.length > 0" class="top-players">
      <h2>Top Players</h2>
      <ul>
        <li v-for="(player, index) in topPlayers" :key="index">{{ player.name }} - {{ player.coins }} Coins</li>
      </ul>
    </div>
    <div v-else>
      <p>No players found.</p>
    </div>
  </main>
</template>

<script setup lang="ts">
import { ref, computed } from 'vue';

const players = ref([
  { name: 'Player 1', coins: 1000 },
  { name: 'Player 2', coins: 750 },
  { name: 'Player 3', coins: 500 }
]);

const topPlayers = computed(() => {
  return players.value.sort((a, b) => b.coins - a.coins).slice(0, 3);
});
</script>

<style>
@media (min-width: 1024px) {
  main {
    min-height: 100vh;
    display: flex;
    align-items: center;
  }
  .top-players {
    margin-bottom:auto;
  }

}
</style>
