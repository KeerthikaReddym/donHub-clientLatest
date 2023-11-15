// app/layout.js
import Navbar from '../component/Navbar';

function Layout({ children }) {
  return (
    <>
      <Navbar />
      <div>{children}</div>
    </>
  );
}

export default Layout;
