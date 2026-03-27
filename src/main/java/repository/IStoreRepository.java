/*Author : Zacharia dipidi
Date: 24 march 2026
 */
package repository;


import Domain.Store;
import java.util.List;

public interface IStoreRepository extends IRepository<Store, String> {
    List<Store>getAll();
}
