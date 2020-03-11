<template>
    <div @click="test()">1111</div>
</template>
<script>
import axios from 'axios'
export default {
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  },
  methods: {
    test () {
      axios.get('http://localhost:8989/test')
        .then(function (response) {
          console.log(response)
        })
        .catch(function (error) {
          console.log(error)
        })
    }
  }
}
</script>
