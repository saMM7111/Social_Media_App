import axios from "axios";
import { API_BASE_URL } from "../../config/api";
import { LOGIN_FAILURE, LOGIN_REQUEST, LOGIN_SUCCESS, REGIS_FAILURE, REGIS_REQUEST, REGIS_SUCCESS } from "./authActionType";
console.log("BASE URL:", API_BASE_URL);


export const loginUserAction = (loginData) => async (dispatch) => {
  dispatch({ type: LOGIN_REQUEST });
  try {
      const { data } = await axios.post(`${API_BASE_URL}/auth/signin`, loginData.data);
      
      if(data.jwt){
        localStorage.setItem("jwt", data.jwt);
      }
      console.log("Login Success", data);
      dispatch({ type: LOGIN_SUCCESS, payload: data.jwt });
  } catch (error) {
      console.log("Login Failed", error);
      dispatch({ type: LOGIN_FAILURE, payload: error.message });
  }
};

export const registerUserAction = (loginData) => async (dispatch) => {
  dispatch({ type: REGIS_REQUEST });
  try {
      const { data } = await axios.post(`${API_BASE_URL}/auth/signup`, loginData.data);
      
      if(data.jwt){
        localStorage.setItem("jwt", data.jwt);
      }
      console.log("Register Success", data);
      dispatch({ type: REGIS_SUCCESS, payload: data.token });
  } catch (error) {
      console.log("Register Failed", error);
      dispatch({ type: REGIS_FAILURE, payload: error.message });
  }
};