package com.example.supershop;

public class Upload {

        private String mName;
        private String mQty;
        private String mImageUrl;

        public Upload() {
            //empty constructor needed
        }

        public Upload(String name, String Quantity , String imageUrl) {
            if (name.trim().equals("")) {
                name = "No Name";
            }

            mName = name;
            mQty=Quantity;
            mImageUrl = imageUrl;
        }

        public String getName() {
            return mName;
        }

        public void setName(String name) {
            mName = name;
        }
        public void setQty(String Quantity) {
             mQty=Quantity;
         }

        public String getImageUrl() {
            return mImageUrl;
        }
        public String getQty() {
            return mQty;
        }

        public void setImageUrl(String imageUrl) {
            mImageUrl = imageUrl;
        }
}
