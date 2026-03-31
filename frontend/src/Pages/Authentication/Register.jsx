import { Button, TextField, FormControlLabel, Radio, RadioGroup } from '@mui/material';
import { ErrorMessage, Field, Form, Formik } from 'formik';
import React from 'react';
import { useDispatch } from 'react-redux';
import * as Yup from 'yup';
import { registerUserAction } from '../../Redux/Auth/authAction';
import { useNavigate } from 'react-router-dom';

const initialValues = { firstName: '', lastName: '', email: '', password: '', gender: '' };

const validationSchema = Yup.object({
  firstName: Yup.string().required('First name is required'),
  lastName: Yup.string().required('Last name is required'),
  email: Yup.string().email('Invalid email format').required('Email is required'),
  password: Yup.string().min(6, 'Password must be at least 6 characters').required('Password is required'),
  gender: Yup.string().required('Gender is required'),
});

const Register = () => {
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const handleSubmit = (values) => {
    console.log('handle submit', values);
    dispatch(registerUserAction({ data: values }));
  };

  return (
    <>
    <Formik
      initialValues={initialValues}
      validationSchema={validationSchema}
      onSubmit={handleSubmit}
    >
      <Form className='space-y-5'>
        <div className='space-y-5'>
          <div>
            <Field
              as={TextField}
              name='firstName'
              placeholder='First Name'
              type='text'
              variant='outlined'
              fullWidth
            />
            <ErrorMessage name='firstName' component='div' className='text-red-500' />
          </div>
          <div>
            <Field
              as={TextField}
              name='lastName'
              placeholder='Last Name'
              type='text'
              variant='outlined'
              fullWidth
            />
            <ErrorMessage name='lastName' component='div' className='text-red-500' />
          </div>
          <div>
            <Field
              as={TextField}
              name='email'
              placeholder='Email'
              type='email'
              variant='outlined'
              fullWidth
            />
            <ErrorMessage name='email' component='div' className='text-red-500' />
          </div>
          <div>
            <Field
              as={TextField}
              name='password'
              placeholder='Password'
              type='password'
              variant='outlined'
              fullWidth
            />
            <ErrorMessage name='password' component='div' className='text-red-500' />
          </div>
          <Field as={RadioGroup} row aria-label='gender' name='gender'>
            <FormControlLabel value='female' control={<Radio />} label='Female' />
            <FormControlLabel value='male' control={<Radio />} label='Male' />
          </Field>
          <ErrorMessage name='gender' component='div' className='text-red-500' />

        </div>
        <Button
          sx={{ padding: '.8rem 0rem' }}
          fullWidth
          type='submit'
          variant='contained'
          color='primary'
        >
          Register
        </Button>
      </Form>
    </Formik>
    <div className='flex gap-2 items-center justify-center pt-5'>
          <p>If you already have an account, please</p>
          <Button onClick={() => navigate('/login')}>Login</Button>
        </div>
    </>
  );
};

export default Register;