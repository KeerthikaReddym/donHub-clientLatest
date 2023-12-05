const Sidebar = () => {
  
  return (
    <div className="w-[250px] p-4 bg-primary">
      <p className="text-white font-bold mb-4">Filter By</p>
      <div className="mb-4">
        <label className="text-white block mb-2">Category</label>
        <select className="p-2 w-full border rounded">
          <option value="all">All</option>
          <option value="textbooks">Textbooks</option>
          <option value="electronics">Electronics</option>
          <option value="furniture">Furniture</option>
          <option value="free">Free Stuff</option>
        </select>
      </div>

      <div className="mb-4">
        <label className="text-white block mb-2">Condition</label>
        <select className="p-2 w-full border rounded">
          <option value="all">All</option>
          <option value="new">New</option>
          <option value="LikeNew">LikeNew</option>
           <option value="Fair">Fair</option>
          <option value="Good">Good</option>
        </select>
      </div>

      <div className="mb-4">
        <label className="text-white block mb-2">Price</label>
        <input
          type="number"
          placeholder="Max Price"
          className="p-2 w-full border rounded"
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
