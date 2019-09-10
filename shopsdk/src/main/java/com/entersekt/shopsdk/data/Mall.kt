package com.entersekt.shopsdk.data

import android.os.Parcel
import android.os.Parcelable

data class Mall (
    val id: Int,
    val name: String,
    val shops: List<Shop>
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.createTypedArrayList(Shop)
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeTypedList(shops)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Mall> {
        override fun createFromParcel(parcel: Parcel): Mall {
            return Mall(parcel)
        }

        override fun newArray(size: Int): Array<Mall?> {
            return arrayOfNulls(size)
        }
    }

}
