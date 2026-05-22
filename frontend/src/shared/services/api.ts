import axios from "axios"

export const imgUrl = "http://localhost/api/img"
const apiUrl = "http://localhost/api"

const api = axios.create({
    baseURL: apiUrl
})

export default api