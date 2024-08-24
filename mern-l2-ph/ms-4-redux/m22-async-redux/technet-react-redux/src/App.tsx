<<<<<<< HEAD
import { onAuthStateChanged } from 'firebase/auth';
import { Toaster } from './components/ui/Toaster';
import MainLayout from './layouts/MainLayout';
import { auth } from './lib/firebase';
import { useEffect } from 'react';
import { useAppDispatch } from './redux/hook';
import { setLoading, setUser } from './redux/features/user/userSlice';

function App() {
  const dispatch = useAppDispatch();

  useEffect(() => {
    dispatch(setLoading(true));

    onAuthStateChanged(auth, (user) => {
      if (user) {
        dispatch(setUser(user?.email));
        dispatch(setLoading(false));
      } else {
        dispatch(setLoading(false));
      }
    });
  }, [dispatch]);

=======
import { Toaster } from './components/ui/Toaster';
import MainLayout from './layouts/MainLayout';

function App() {
>>>>>>> 8139f5ff3f06d42d06f9abd790073f253087168a
  return (
    <div>
      <Toaster />
      <MainLayout />
    </div>
  );
}

export default App;
