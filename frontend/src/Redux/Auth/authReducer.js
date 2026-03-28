
import { LOGIN_FAILURE, LOGIN_REQUEST, LOGIN_SUCCESS, REGIS_FAILURE, REGIS_REQUEST, REGIS_SUCCESS } from "./authActionType";


const initialState = {
  jwt:null,
  loading:false,
  error:null
}
export const authReducer = (state = initialState, action) => {

  switch (action.type) {
    case LOGIN_REQUEST:
    case REGIS_REQUEST:
      return {
        ...state,
        loading:true,
        error:null
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
      return {
        ...state,
        jwt: null,
        loading:false,
        error: action.payload
      };
    default:
      return state;
  }

}