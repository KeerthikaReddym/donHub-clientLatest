const Sidebar = () => {
  
  return (
    <div className="w-[250px] p-4 bg-primary">
      <p className="text-white font-bold mb-4">Filter By</p>
      <div className="mb-4">
        <label className="text-white block mb-2">Category</label>
        <select className="p-2 w-full border rounded text-black bg-white">
        <option value="">Select Category</option>
          <option value="EDUCATIONAL_MATERIALS">Educational Materials</option>
          <option value="ELECTRONICS_AND_GADGETS">Electronics and Gadgets</option>
          <option value="FURNITURE_AND_HOME_ESSENTIALS">
            Furniture and Home Essentials
          </option>
          <option value="CLOTHINGS_AND_ACCESSORIES">
            Clothings and Accessories
          </option>
          <option value="TRANSPORTATION">Transportation</option>
          <option value="MUSICAL_INSTRUMENTS">Musical Instruments</option>
          <option value="FREEBIES">Freebies</option>
          <option value="HEALTH">Health</option>
          <option value="ENTERTAINMENT">Entertainment</option>
          <option value="DIYS">DIYs</option>
          <option value="MISCELLANEOUS">Miscellaneous</option>
        </select>
      </div>

      <div className="mb-4">
        <label className="text-white block mb-2">Condition</label>
        <select className="p-2 w-full border rounded text-black bg-white">
        <option value="">Select Condition</option>
          <option value="NEW">New</option>
          <option value="LIKE_NEW">Like New</option>
          <option value="FAIR">Fair</option>
          <option value="GOOD">Good</option>
        </select>
      </div>

      <div className="mb-4">
        <label className="text-white block mb-2">Price</label>
        <input
          type="number"
          placeholder="Max Price"
          className="p-2 w-full border rounded text-black bg-white"
        />
      </div>

      {/* Add additional filters as needed */}

      <button className="bg-white text-primary p-2 rounded w-full">
        Apply Filters
      </button>
    </div>
  );
};

export default Sidebar;
