
import { LOGIN_FAILURE, LOGIN_REQUEST, LOGIN_SUCCESS, REGIS_FAILURE, REGIS_REQUEST, REGIS_SUCCESS, GET_PROFILE_FAILURE, GET_PROFILE_REQUEST, GET_PROFILE_SUCCESS, UPDATE_PROFILE_FAILURE, UPDATE_PROFILE_REQUEST, UPDATE_PROFILE_SUCCESS } from "./authActionType";


const initialState = {
  jwt:null,
  loading:false,
  error:null,
  user:null
}
export const authReducer = (state = initialState, action) => {

  switch (action.type) {
    case LOGIN_REQUEST:
    case REGIS_REQUEST:
    case GET_PROFILE_REQUEST:
    case UPDATE_PROFILE_REQUEST:
      return {
        ...state,
        loading:true,
        error:null
      };

    case GET_PROFILE_SUCCESS:
    case UPDATE_PROFILE_SUCCESS:
      return {
        ...state,
        user:action.payload,
        error:null,
        loading:false,
      };


    case LOGIN_SUCCESS:
    case REGIS_SUCCESS:
      return {
        ...state,
        jwt: action.payload,
        loading:false,
        error:null
      };
    case LOGIN_FAILURE:
    case REGIS_FAILURE:
    case GET_PROFILE_FAILURE:
    case UPDATE_PROFILE_FAILURE:
      return {
        ...state,
        loading:false,
        error: action.payload
      };
    default:
      return state;
  }

}