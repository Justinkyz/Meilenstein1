<template>
  <ul>
    <li v-for="(item, index) in items" :key="index">{{ item }}</li>
  </ul>
</template>

<script setup lang="ts">
import { defineProps } from 'vue';

const props = defineProps<{
  items: string[];
}>();
</script>