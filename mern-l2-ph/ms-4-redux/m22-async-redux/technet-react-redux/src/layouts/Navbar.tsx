import { Link } from 'react-router-dom';
import { Avatar, AvatarFallback, AvatarImage } from '../components/ui/avatar';
import { Button } from '../components/ui/button';
import { DropdownMenuSeparator } from '../components/ui/dropdown-menu';
import { DropdownMenuLabel } from '../components/ui/dropdown-menu';
import {
  DropdownMenuItem,
  DropdownMenu,
  DropdownMenuTrigger,
  DropdownMenuContent,
} from '../components/ui/dropdown-menu';
import { HiOutlineSearch } from 'react-icons/hi';
import Cart from '../components/Cart';
import logo from '../assets/images/technet-logo.png';
<<<<<<< HEAD
import { useAppDispatch, useAppSelector } from '@/redux/hook';
import { signOut } from 'firebase/auth';
import { auth } from '@/lib/firebase';
import { setLoading, setUser } from '@/redux/features/user/userSlice';

export default function Navbar() {
  const { user, isLoading, isError, error } = useAppSelector(
    (state) => state.user
  );

  const dispatch = useAppDispatch();

  const handleLogout = () => {
    signOut(auth).then(() => {
      dispatch(setUser(null));
    });
  };

=======

export default function Navbar() {
>>>>>>> 8139f5ff3f06d42d06f9abd790073f253087168a
  return (
    <nav className="w-full h-16 fixed top backdrop-blur-lg z-10">
      <div className="h-full w-full bg-white/60">
        <div className="flex items-center justify-between w-full md:max-w-7xl h-full mx-auto ">
          <div>
            <img className="h-8" src={logo} alt="log" />
          </div>
          <div>
            <ul className="flex items-center">
              <li>
                <Button variant="link" asChild>
                  <Link to="/">Home</Link>
                </Button>
              </li>
              <li>
                <Button variant="link" asChild>
                  <Link to="/products">Products</Link>
                </Button>
              </li>
              <li>
                <Button variant="link" asChild>
                  <Link to="/checkout">Checkout</Link>
                </Button>
              </li>
              <li>
                <Button variant="ghost">
                  <HiOutlineSearch size="25" />
                </Button>
              </li>
              <li>
                <Cart />
              </li>
              <li className="ml-5">
                <DropdownMenu>
                  <DropdownMenuTrigger className="outline-none">
                    <Avatar>
                      <AvatarImage src="https://github.com/shadcn.png" />
                      <AvatarFallback>CN</AvatarFallback>
                    </Avatar>
                  </DropdownMenuTrigger>
                  <DropdownMenuContent>
                    <DropdownMenuLabel>Account</DropdownMenuLabel>
                    <DropdownMenuSeparator />
                    <DropdownMenuItem className="cursor-pointer">
                      Profile
                    </DropdownMenuItem>
<<<<<<< HEAD
                    {!user?.email && (
                      <>
                        <Link to="/login">
                          <DropdownMenuItem className="cursor-pointer">
                            Login
                          </DropdownMenuItem>
                        </Link>
                        <Link to="/signup">
                          <DropdownMenuItem className="cursor-pointer">
                            Signup
                          </DropdownMenuItem>
                        </Link>
                      </>
                    )}
                    {user?.email && (
                      <DropdownMenuItem
                        className="cursor-pointer"
                        onClick={() => handleLogout()}
                      >
                        logout
                      </DropdownMenuItem>
                    )}
=======
                    <DropdownMenuItem className="cursor-pointer">
                      Billing
                    </DropdownMenuItem>
                    <DropdownMenuItem className="cursor-pointer">
                      Team
                    </DropdownMenuItem>
                    <DropdownMenuItem className="cursor-pointer">
                      Subscription
                    </DropdownMenuItem>
>>>>>>> 8139f5ff3f06d42d06f9abd790073f253087168a
                  </DropdownMenuContent>
                </DropdownMenu>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </nav>
  );
}
