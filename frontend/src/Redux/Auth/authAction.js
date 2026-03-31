import axios from "axios";
import { API_BASE_URL } from "../../config/api";
import { LOGIN_FAILURE, LOGIN_REQUEST, LOGIN_SUCCESS, REGIS_FAILURE, REGIS_REQUEST, REGIS_SUCCESS, GET_PROFILE_FAILURE, GET_PROFILE_REQUEST, GET_PROFILE_SUCCESS, UPDATE_PROFILE_FAILURE, UPDATE_PROFILE_REQUEST, UPDATE_PROFILE_SUCCESS } from "./authActionType";
import { api } from "../../config/api";


export const loginUserAction = (loginData) => async (dispatch) => {
  dispatch({ type: LOGIN_REQUEST });
  try {
      const { data } = await axios.post(`${API_BASE_URL}/auth/signin`, loginData.data);


      if (data?.token) {
        localStorage.setItem("jwt", data.token);
      }
      console.log("Login Success", data);
      dispatch({ type: LOGIN_SUCCESS, payload: data.token });
  } catch (error) {
      console.log("Login Failed", error);
      dispatch({ type: LOGIN_FAILURE, payload: error.message });
  }
};

export const registerUserAction = (registerData) => async (dispatch) => {
  dispatch({ type: REGIS_REQUEST });
  try {
      const { data } = await axios.post(`${API_BASE_URL}/auth/signup`, registerData.data);

  
      if (data?.token) {
        localStorage.setItem("jwt", data.token);
      }
      console.log("Register Success", data);
      dispatch({ type: REGIS_SUCCESS, payload: data.token });
  } catch (error) {
      console.log("Register Failed", error);
      dispatch({ type: REGIS_FAILURE, payload: error.message });
  }
};

export const getProfileAction = (jwt) => async (dispatch) => {
  if (!jwt) return;
  dispatch({ type: GET_PROFILE_REQUEST });
  try {
    const { data } = await axios.get(`${API_BASE_URL}/api/users/profile`, {
      headers: { Authorization: `Bearer ${jwt}` }
    });
      console.log("Get Profile Success", data);
      dispatch({ type: GET_PROFILE_SUCCESS, payload: data });
  } catch (error) {
      console.log("Get Profile Failed", error);
      dispatch({ type: GET_PROFILE_FAILURE, payload: error.message });
  }
};

export const updateProfileAction = (reqData) => async (dispatch) => {
  const token = localStorage.getItem("jwt");
  if (!token) {
    dispatch({ type: UPDATE_PROFILE_FAILURE, payload: "Missing auth token" });
    return;
  }

  dispatch({ type: UPDATE_PROFILE_REQUEST });
  try {
    const { data } = await axios.put(
      `${API_BASE_URL}/api/users`,
      reqData,
      {
        headers: { Authorization: `Bearer ${token}` }
      }
    );
    console.log("Update Profile Success", data);
    dispatch({ type: UPDATE_PROFILE_SUCCESS, payload: data });
  } catch (error) {
    console.log("Update Profile Failed", error);
    dispatch({ type: UPDATE_PROFILE_FAILURE, payload: error.message });
  }
};

