import React from 'react';
import Link from 'next/link';

function Navbar() {
  return (
    <nav className="navbar">
      {/* Add your navbar content here */}
      <Link href="/">
        Home
      </Link>
      <Link href="/about">
        About
      </Link>
      <Link href="/contact">
        Contact
      </Link>
      {/* Add more navigation links as needed */}
    </nav>
  );
}

export default Navbar;
