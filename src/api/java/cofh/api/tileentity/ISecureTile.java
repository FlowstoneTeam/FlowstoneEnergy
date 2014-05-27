package cofh.api.tileentity;

/**
 * Implement this interface on Tile Entities which have access restrictions.
 * 
 * @author King Lemming
 * 
 */
public interface ISecureTile {

	/**
	 * Enum for Access Modes - Restricted is Friends Only, Private is Owner only.
	 * 
	 * @author King Lemming
	 * 
	 */
	public static enum AccessMode {
		PUBLIC, RESTRICTED, PRIVATE;

		public boolean isPublic() {

			return this == PUBLIC;
		}

		public boolean isRestricted() {

			return this == RESTRICTED;
		}

		public boolean isPrivate() {

			return this == PRIVATE;
		}

		public static AccessMode stepForward(AccessMode curAccess) {

			return curAccess == PUBLIC ? RESTRICTED : curAccess == PRIVATE ? PUBLIC : PRIVATE;
		}

		public static AccessMode stepBackward(AccessMode curAccess) {

			return curAccess == PUBLIC ? PRIVATE : curAccess == PRIVATE ? RESTRICTED : PUBLIC;
		}
	}

	public boolean setAccess(AccessMode access);

	public boolean setOwnerName(String name);

	public AccessMode getAccess();

	public String getOwnerName();

	public boolean canPlayerAccess(String name);

}
